package dao;

import java.util.ArrayList;
import java.util.List;

import DO.GoodsDO;



public class goodsDaoImp implements goodsDao {

	@Override
	public List show() {
		List<GoodsDO> list = new ArrayList<GoodsDO>();
		GoodsDO g;
		for(int i=1;i<=5;i++) {
			 g = new GoodsDO(i, "商品"+i, i+10, i*10);
			list.add(g);
		}
		return list;
	}

}
