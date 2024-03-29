package cvc.framework.util.excel;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cvc.framework.util.excel.ExcelColumn;
import cvc.framework.util.excel.ExcelRow;

public class ExcelUtil 
{

	/**
	 * 根据获取的数据生成/返回一个excel文件
	 * xlsFile_name:要导出的文件名
	 * rows：要导出的数据
	 * columns：要导出的列
	 * */
	public static <T> boolean expoerDataExcel(HttpServletResponse response,String xlsFile_name,List<T> rows,List<ExcelColumn> columns)
	{
		XSSFWorkbook wb;
		wb = new XSSFWorkbook();
        int rowNo = 0;      //总行号
        XSSFSheet sheet = wb.createSheet();
        XSSFRow row = sheet.createRow(rowNo);
        
        
        for(int i=0;i<columns.size();i++)
        {
        	 Cell cell_tem = row.createCell(i);
             cell_tem.setCellValue(columns.get(i).title);
        }
        rowNo++;
        

        
    
        for (int k=0;k<rows.size();k++) 
        {
        	
        	T obj=rows.get(k);
        	Class clazz=obj.getClass();
        	
        	XSSFRow datarow = sheet.createRow(rowNo);
        	
        	 
        	for(int i=0;i<columns.size();i++)
            {
        		Cell datacell = datarow.createCell(i);
        		String filed=columns.get(i).name;
        		PropertyDescriptor pd;
				try 
				{
					pd = new PropertyDescriptor(filed, clazz);
	        		Method getMethod = pd.getReadMethod();//获得get方法
	        		Object value=getMethod.invoke(obj);
	        		datacell.setCellValue(value.toString());
				}
				catch (Exception e) 
				{
					String ss=e.getMessage();
					System.out.println(ss);
				}
            }
			rowNo++;
        	
        }
        
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setCharacterEncoding("utf-8"); 
        //设置浏览器响应头对应的Content-disposition
        String file_name;
		try {
			file_name = new String(xlsFile_name.getBytes(), "ISO-8859-1");
		} catch (UnsupportedEncodingException e2) 
		{
			file_name=xlsFile_name;
		}
        response.setHeader("Content-disposition", "attachment;filename="+file_name);
        try {
			response.flushBuffer();
		} catch (IOException e1) {
		}
        
        
        OutputStream outputStream;
		try 
		{
			outputStream = response.getOutputStream();
	        wb.write(response.getOutputStream());
	        wb.close();
	        outputStream.flush();
	        outputStream.close();
		}
		catch (IOException e) 
		{
			 return false;
		}
		return true;
	}
	/**
	 * 获取excel文件中相应的部分行的集合
	 * @param filename
	 * @param sheetname
	 * @param startrow
	 * @return
	 * @throws IOException
	 */
	public static   List<ExcelRow> getExcel(String filename,String sheetname,int startrow) throws IOException
	{
		List <ExcelRow> l=new ArrayList<ExcelRow>();
		
		
		XSSFWorkbook wb = new XSSFWorkbook(filename);
		XSSFSheet sheet=wb.getSheet(sheetname);
		int count=sheet.getLastRowNum();
		
		for(int i=startrow;i<=count;i++)
		{
			ExcelRow erow=new ExcelRow();
			XSSFRow xrow=sheet.getRow(i);
			for(int j=0;j<sheet.getLastRowNum();j++)
			{
				if(xrow.getCell(j)!=null)
				{
					String cell="";
					CellType type=xrow.getCell(j).getCellType();
					if(type.name().equals("NUMERIC"))
					{
						
						//  获取单元格值的格式化信息
		                String dataFormat = xrow.getCell(j).getCellStyle().getDataFormatString();
		                //日期暂时不判断-因为有bug
		                if(HSSFDateUtil.isCellDateFormatted(xrow.getCell(j)))
		                {
							Date date = xrow.getCell(j).getDateCellValue();
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							cell=sdf.format(date);
//							DataFormatter formatter = new DataFormatter();  
//							String retValue = formatter.formatCellValue(xrow.getCell(j));  
		                }
		                else
		                {
							double d=xrow.getCell(j).getNumericCellValue();
							cell=d+"";
		                }
					}
					else if(type.name().equals("STRING"))
					{
						cell=xrow.getCell(j).getStringCellValue();
					}
					else
					{
						xrow.getCell(j).setCellType(CellType.STRING);
						cell=xrow.getCell(j).getStringCellValue();
					}
					erow.cells.add(cell);
				}
			}
			l.add(erow);
		}
		wb.close();
		return l;
	}
	

}
