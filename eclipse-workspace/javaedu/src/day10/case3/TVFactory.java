package day10.case3;

public class TVFactory { // 객체 생성을 담당하는 클래스명은 ~Factory, ~Builder로 짓는게 관례
	public static TV getTV(String beanName){
		TV obj = null;
		if(beanName.equals("samsung")){
			obj = new SamsungTV();
		} else if(beanName.equals("lg")){
			obj = new LgTV();
		}
		return obj;
	}

}
