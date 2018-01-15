package testScript;


import Entity.Cases;
import Entity.Step;
import IDao.CasesDao;
import IDao.StepDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:springConfig/spring-mybatis.xml", "classpath:springConfig/spring-mvc.xml" })
public class coreTes {

    @Autowired
    private StepDao stepDao;

    @Autowired
    private CasesDao casesDao;

    @Test
    public void addstep(){
        Step step=new Step();
        step.setElement("test");
        step.setOtype("1");
        step.setEtype("33");
        step.setSkeys("test");
        step.setSwap("2");
        step.setcId(0);
        stepDao.addStep(step);

    }


    @Test
    public void addCase(){
        Cases cases=new Cases();
        cases.setCaseName("sss");
        cases.setContext("测试案例备注");
        casesDao.addCase(cases);

    }

    @Test
    public void updatestep(){
        Step step=new Step();
        step.setElement("test1");
        step.setOtype("1");
        step.setEtype("33");
        step.setSkeys("test");
        step.setSwap("2");
        step.setcId(0);
        step.setText("修改数据");
        step.setId(1);
        stepDao.updateStep(step);
    }

    @Test
    public void updateCase(){
        Cases cases=new Cases();
        cases.setCaseName("饮鸩止渴");
        cases.setContext("测试案例备注");
        cases.setId(1);
        casesDao.updateCase(cases);

    }

    @Test
    public void deletestep(){
        stepDao.deleteStep(2);
    }

    @Test
    public void findstep(){
        List<Step> list=stepDao.findSteps(0);
        for(Step step:list){
            System.out.println(step.getElement());
        }
    }

    @Test
    public void findCases(){
       // casesDao.findCasesByEntry(null).get(0).getCaseName();
        Cases cases=new Cases();
        cases.setCaseName("s");
        List<Cases> cases1=casesDao.findCasesByEntry(cases);
        for(Cases cases2:cases1){
            System.out.println(cases2.getCaseName());
        }
    }



}
