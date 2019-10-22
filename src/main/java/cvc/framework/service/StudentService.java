package cvc.framework.service;




import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cvc.framework.entity.Student;
import cvc.framework.mapper.IStudentMapper;
import cvc.framework.util.excel.ExcelRow;
import cvc.framework.util.excel.ExcelUtil;

@Service
public class StudentService 
{

	@Autowired
	private IStudentMapper mapper;
	
	public List<Student> searchAllStu(){
		return mapper.searchAllStu();
	}
	
	public int addStu(Student student){
		return mapper.addStu(student);
	}
	//读取MultipartFile的excel文件-用MultipartFile类读取excel文件以后用transferTo()转存到硬盘上
	public int addManySt(MultipartFile file) {
		if(!file.isEmpty()){
			//这里有bug待调--windows上便没有这个问题
            File excelfile = new File("D:\\学员管理系统\\upload\\"+ file.getOriginalFilename());
            try {
                file.transferTo(excelfile);
                List<ExcelRow> rows=ExcelUtil.getExcel("D:\\学员管理系统\\upload\\"+ file.getOriginalFilename(), "sheet1", 1);
                List<Student> students=new ArrayList<Student>();
                for(ExcelRow row:rows) {
                	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                	if(row.cells.size()>4) {
                		java.util.Date date=sdf.parse(row.cells.get(4));
                    	students.add(new Student(row.cells.get(0),row.cells.get(2),row.cells.get(3),date));
                	}
                }
                return mapper.batchInsert(students);
            }catch (Exception e) {
                excelfile.delete();
                e.printStackTrace();
            }
        }else{
            return 0;
        }
		return 1;
	}
}
