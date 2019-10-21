package cvc.framework.service;




import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
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
			//这里有bug待调
            File excelfile = new File("/Users/suwan/Documents/pictures/upload/"+ file.getOriginalFilename());
            try {
            	if(!excelfile.exists())excelfile.createNewFile();
                file.transferTo(excelfile);
                List<ExcelRow> rows=ExcelUtil.getExcel("/Users/suwan/Documents/pictures/upload/"+ file.getOriginalFilename(), "table_1", 0);
				System.out.println(rows.get(0).cells.get(0));
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
