package com.hxh.service;

import com.hxh.dao.MenuDao;
import com.hxh.dao.UserDao;
import com.hxh.entity.Menu;
import com.hxh.entity.Page;
import com.hxh.entity.User;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.Date;
import java.util.List;

/**
 * @auth hxh
 * @date 2020/6/23 0:27
 * @Description
 */
public class UserService {
    private UserDao userDao=new UserDao();
//    public List<User> list(String name){
//        return userDao.listAll(name);
//    }
//    public void addUser(User user){
//        user.setId(null);
//        user.setRegisterTime(new Date());
//        userDao.addUser(user);
//    }
//    public User getUserById(Integer id){
//       return  userDao.getUserById(id);
//    }
//    public void delete(Integer id){
//        userDao.delete(id);
//    }
//    public Integer getCount(){
//        return userDao.getCount();
//    }
//    public void update(User user){
//        userDao.update(user);
//    }

    //    封装后
    public Page listAll(String username, String sex1, String strPage) {
        Page page = new Page();
        if (!StringUtils.isEmpty(strPage)) {
            page.setPageCurrent(Integer.valueOf(strPage));
        }
        page.setCount(userDao.getCount(username, sex1));
        List<User> list = userDao.listAll(username, sex1, page);
        page.setData(list);
        return page;
    }

    public Integer getCount(String username, String sex1) {
        return userDao.getCount(username, sex1);
    }
//添加用户
    public void addUser(User user) {
        user.setId(null);
        user.setRegisterTime(new Date());
        userDao.addUser(user);
    }
    //登录验证
    public Boolean findName(String username) {
        User user = userDao.findName(username);
        if (user != null) {
//            账户已存在
            return false;
        }
//        数据不存在则为真
        return true;
    }

    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }
    //修改密码
    public void updatePs(String username, String newPs) {
        userDao.updatePs(username, newPs);
    }
//换头像
    public void updatePic(Integer id, String pic) {
        userDao.updatePic(id, pic);
    }
    //微信登录
    public User findByWxOpenid(String WxOpenid) {
    return userDao.findByWxOpenid(WxOpenid);
    }

    public Workbook listForExcel( String username){
        String[] headers = new String[]{"用户名","部门名称" ,"性别", "年龄",};
        Workbook wb=new XSSFWorkbook();
        Sheet sheet=wb.createSheet("工作簿");
        Row headerRow=sheet.createRow(0);
        for (int i = 0; i <4 ; i++) {
            headerRow.createCell(i).setCellValue(headers[i]);
        }

        List<User>list=userDao.listForExcel(username);
        Row row;
        for (int i = 0; i <list.size() ; i++) {
            row=sheet.createRow(i+1);
            row.createCell(0).setCellValue(list.get(i).getUsername());
            row.createCell(1).setCellValue(list.get(i).getDeptName()==null? "":list.get(i).getDeptName());
            row.createCell(2).setCellValue(list.get(i).getAge()==null? "":list.get(i).getAge().toString());
            String sex="";
            if (list.get(i).getSex()!=null){
                if (list.get(i).getSex()==1){
                    sex="男";
                }
                else if(list.get(i).getSex()==0){
                    sex="女";
                }
            }
            else {
                sex="其他";
            }
            row.createCell(3).setCellValue(sex);
        }
        return wb;
    }
}
