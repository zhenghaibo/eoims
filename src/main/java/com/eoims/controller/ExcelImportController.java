package com.eoims.controller;
import com.eoims.domain.AgriculturalBank;
import com.eoims.service.impl.ExcelImportServiceImpl;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;

@Controller
@RestController
@RequestMapping("/excelImport")
public class ExcelImportController {
    @Autowired
    private ExcelImportServiceImpl excelImportServiceImpl;

    @RequestMapping(value={"/uploadAgricul.do"})
    public String uploadAgricul(String path){
        try {
            InputStream fi = new FileInputStream(path);
            XSSFWorkbook wb=new XSSFWorkbook(fi);
            XSSFSheet sheet=wb.getSheet("Sheet0");
            int rowNums=sheet.getLastRowNum();
            for(int i=1;i<rowNums+1;i++){
                XSSFRow row=sheet.getRow(i);
                AgriculturalBank ab=new AgriculturalBank();
                ab.setOrderno(row.getCell(0).getStringCellValue());
                ab.setOrderdate(row.getCell(1).getStringCellValue());
                ab.setOrdertype(row.getCell(2).getStringCellValue());
                ab.setUseraccount(row.getCell(3).getStringCellValue());
                ab.setBusiname(row.getCell(4).getStringCellValue());
                ab.setMarketerp(row.getCell(5).getStringCellValue());
                ab.setMarketname(row.getCell(6).getStringCellValue());
                ab.setOnelevel(row.getCell(7).getStringCellValue());
                ab.setTwolevel(row.getCell(8).getStringCellValue());
                ab.setThreelevel(row.getCell(9).getStringCellValue());
                ab.setBranch(row.getCell(10).getStringCellValue());
                ab.setGoodsmodel(row.getCell(11).getStringCellValue());
                ab.setGoodscode(row.getCell(12).getStringCellValue());
                ab.setGoodsname(row.getCell(13).getStringCellValue());
                ab.setSellcount(Integer.parseInt(row.getCell(14).getStringCellValue()));
                ab.setUserlevel(row.getCell(15).getStringCellValue());
                ab.setPayway(row.getCell(16).getStringCellValue());
                ab.setPavobeforeprice(new BigDecimal(row.getCell(17).getStringCellValue()));
                ab.setPavoafterprice(new BigDecimal(row.getCell(18).getStringCellValue()));
                ab.setPavobeforemoney(new BigDecimal(row.getCell(19).getStringCellValue()));
                ab.setPavoaftermoney(new BigDecimal(row.getCell(20).getStringCellValue()));
                ab.setJdpaymoney(new BigDecimal(row.getCell(21).getStringCellValue()));
                ab.setGiftcardpaymoney(new BigDecimal(row.getCell(22).getStringCellValue()));
                ab.setAccountbalance(new BigDecimal(row.getCell(23).getStringCellValue()));
                ab.setTpavomoney(new BigDecimal(row.getCell(24).getStringCellValue()));
                ab.setUsermeetmoney(new BigDecimal(row.getCell(25).getStringCellValue()));
                ab.setFare(new BigDecimal(row.getCell(26).getStringCellValue()));
                ab.setPaydate(row.getCell(27).getStringCellValue());
                ab.setOutstoredate(row.getCell(28).getStringCellValue());
                ab.setOrdercomdate(row.getCell(29).getStringCellValue());
                ab.setProvince(row.getCell(30).getStringCellValue());
                ab.setCity(row.getCell(31).getStringCellValue());
                ab.setCounty(row.getCell(32).getStringCellValue());
                ab.setRegion(row.getCell(33).getStringCellValue());
                ab.setServiceline(row.getCell(34).getStringCellValue());
                ab.setIsgive(row.getCell(35).getStringCellValue());
                ab.setOrderstatus(row.getCell(36).getStringCellValue());
                ab.setAccountdate(row.getCell(37).getStringCellValue());
                ab.setOrdercate(row.getCell(38).getStringCellValue());
                ab.setValidflag(row.getCell(39).getStringCellValue());
                ab.setOrdermoney(new BigDecimal(row.getCell(40).getStringCellValue()));
                ab.setParentno(row.getCell(41).getStringCellValue());
                ab.setContractno(row.getCell(42).getStringCellValue());
                ab.setChanel(row.getCell(43).getStringCellValue());
                ab.setChaneldetail(row.getCell(44).getStringCellValue());
               // ab.setSettlebilldate(row.getCell(45).getStringCellValue());
                excelImportServiceImpl.addAgriculturalBank(ab);
            }
            fi.close();
        }catch (Exception e){
            e.printStackTrace();
        }

     return "success";
    }
}
