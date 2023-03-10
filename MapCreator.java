//
//
//  @ Project : HDT6
//  @ File Name : MapCreator.java
//  @ Date : 05/03/2023
//  @ Author : Nicolle Gordillo  
//
//
public class MapCreator extends mapFactory{

    @Override
    public IMap createMap(int tipo) {
        IMap map;
		
		switch(tipo) {
		case 1:{
			map = new hashMap();
		}break;
		
		case 2:{
			map = new treeMap();
		}break;
		case 3:{
			map = new linkedHashMap();
		}break;
		default:{
			map = null;
		}break;
		}
		
		return map;
        
    }
    
}
