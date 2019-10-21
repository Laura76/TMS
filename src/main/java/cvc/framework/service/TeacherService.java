package cvc.framework.service;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cvc.framework.entity.Teacher;
import cvc.framework.mapper.ITeacherMapper;
import cvc.framework.util.MessageProperties;
import freemarker.template.Configuration;
import freemarker.template.Template;
import sun.misc.BASE64Encoder;

@Service
public class TeacherService 
{

	@Autowired
	private ITeacherMapper mapper;
    @Autowired
    private MessageProperties config; //用来获取file-message.properties配置文件中的信息
	
	public int addTe(Teacher teacher){
		int res=mapper.addTe(teacher);
		return res;
	}
	public List<Teacher> searchAllTe(){
		return mapper.searchAllTe();
	}
	//导出为word文档
	public List<Teacher> downloadResume(String teid){
		List<Teacher> te=mapper.downloadResume(teid);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if(te.size()>0) {
			//修改一下gender和photo
			String tegender=te.get(0).getTegender()==0?"男":"女";
			String tephoto=imageToBase64Str(config.getUpPath()+te.get(0).getTephoto().replace('/', '\\'));
			dataMap.put("tename", te.get(0).getTename());
			dataMap.put("tegender", tegender);
			dataMap.put("teprofessional", te.get(0).getTeprofessional());
			dataMap.put("teeducation", te.get(0).getTeeducation());
			dataMap.put("teidnumber", te.get(0).getTeidnumber());
			dataMap.put("tephoto", tephoto);
		}
		te=mapper.searchTeClass(teid);
	    List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
	    for(int i=0;i<te.size();i++) {
	    	Map<String,Object> map=new HashMap<String,Object>();
	    	//将date转化为string
	    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM");
	    	String clstarttime = formatter.format(te.get(i).getClstarttime());
	    	String clendtime = formatter.format(te.get(i).getClendtime());
	    	map.put("clstarttime", clstarttime);
	    	map.put("clendtime", clendtime);
	    	map.put("caname", te.get(i).getCaname());
	    	map.put("clname", te.get(i).getClname());
	    	map.put("stcount", te.get(i).getStcount());
	    	list1.add(map);
	    }
	    dataMap.put("list1", list1);
	    @SuppressWarnings("deprecation")
	    Configuration configuration = new Configuration();
	    configuration.setDefaultEncoding("utf-8");
	    configuration.setClassForTemplateLoading(this.getClass(), "/templates");
	    File outFile = new File("D:/outFilessa"+Math.random()*10000+".doc");//输出路径
	    Template t=null;  
	    Writer out = null;
	    try {
	        t = configuration.getTemplate("简历模板.ftl", "utf-8"); //文件名，获取模板
	        out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"));  
	        t.process(dataMap, out);
	    } catch (Exception e) {
	        e.printStackTrace();  
	    } finally {
	        try {
	            out.close();
	        } catch (IOException  e) {
	            e.printStackTrace(); 
	        }
	    }
	return null;
	}
	//将获取的图片转换为BASE64字符串
	public static String imageToBase64Str(String imgFile) {
	   InputStream inputStream = null;
	   byte[] data = null;
	   try {
	     inputStream = new FileInputStream(imgFile);
	     data = new byte[inputStream.available()];
	     inputStream.read(data);
	     inputStream.close();
	   } catch (IOException e) {
	     e.printStackTrace();
	   }
	   // 加密
	   BASE64Encoder encoder = new BASE64Encoder();
	   return encoder.encode(data);
	 }
}
