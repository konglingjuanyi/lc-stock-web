package biztest.group;

import java.util.List;

import javax.annotation.Resource;

import model.GroupInfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import biz.GroupInfoBiz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class GroupInfoServiceTest {

	@Resource
	private GroupInfoBiz groupInfoBiz;

	@Test
	public void list() {
		List<GroupInfo> list = this.groupInfoBiz.getGroupList(null);
		if(list.size()>0){
		for (GroupInfo item : list) {
			System.out.println(item.getName());
		}
		}else{
			System.out.println("list length is 0");
		}
	}

}
