

import java.io.IOException;

import com.jeff.tianti.common.util.GenCodeUtil;
import com.jeff.tianti.org.entity.XcFundsRecordModel;
import com.jeff.tianti.org.entity.XcRechargeOrderModel;
import com.jeff.tianti.org.entity.XcUserModel;

public class GenCodeTest {
	
	public static void main(String[] args) throws IOException{
		//基本包目录（不用到entity那一层级）
		String s = "com.jeff.tianti.org";
		//作者
		String writer = "percy";
		//Demo为Entity类（放上自己新增的实体类即可）
		GenCodeTest.autoGenAllCode(XcUserModel.class,s,writer);

	}
	
	/**
	 * 组装所有生成类
	 * @param c
	 * @param commonPackage
	 * @param writer
	 * @throws IOException
	 */
	public static void autoGenAllCode(Class c,String commonPackage,String writer) throws IOException{
//		GenCodeUtil.createQueryDTO(c, commonPackage, writer);
////		GenCodeUtil.createFrontQueryDTO(c, commonPackage, writer);
//		GenCodeUtil.createDaoCustomInterface(c,commonPackage,writer);
//		GenCodeUtil.createDaoInterface(c,commonPackage,writer);
//		GenCodeUtil.createDaoClass(c,commonPackage,writer);
//		GenCodeUtil.createServiceClass(c,commonPackage,writer);
		GenCodeUtil.createStandardAddJsp("/xcusers");
		GenCodeUtil.createControllerClass(c, commonPackage, "com.jeff.tianti.controller", writer, true);
	}

}
