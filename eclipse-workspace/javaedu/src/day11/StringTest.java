package day11;
public class StringTest {
	public static void main(String[] args) {
		System.out.println("1".length()); 			// 1	
		System.out.println("가나다".length()); 		// 3			
		System.out.println("abc".charAt(1)); 		// b	
		System.out.println("abc".toUpperCase());	// ABC 
		
		String str1 = "ABCDEFGHIJ";
		String str2 = "abcdefgfhij";		
		System.out.println(str1.substring(4));    	// EFGHIJ  
		System.out.println(str1.substring(0, 3));  	// ABC	
		System.out.println(str2.indexOf("f"));      // 5 		  
		System.out.println(str2.lastIndexOf("f"));  // 7    
		System.out.println(str2.replace('h', 'H')); // abcdefgfHij	    
		
		String str3 = "java jdbc html5 css javascript servlet jsp ajax";
		String[] ary = str3.split(" ");   
		
		for(int i=0; i < ary.length; i++){
			System.out.println(ary[i]); 
			// java 
			// jdbc 
			// html5 
			// css 
			// javascript 
			// servlet 
			// jsp 
			// ajax
		}		
		char ch[] = str3.toCharArray();
		System.out.println(str3.length() + " ---- " + ch.length); //47 ---- 47
		for(int i=0; i < ch.length; i++){
			System.out.print(ch[i] + " "); //j a v a  j d b c  h t m l  c s s  j a v a s c r i p t  s e v l e t  j s p  a j a x
		}
	}
}













