package utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
/**
* The CommonUtility store all function that use to common function for other classes.

* @author  Phan
* @since   2018 Nov 12th
*/
public class CommonUtility {
	public List<String> splitEmptyOnString( String input) {
		//str = "j, k, , q "; 
		input = input.replaceAll("\\s+","");
		String[] arrOfStr = input.split(","); 
		return removeEmptyfromArray(arrOfStr);
	} 
	 public int cutNumber(String s) {
		String[] arrOfStr = s.split(" ");
		removeEmptyfromArray(arrOfStr);
		List<String> list =removeEmptyfromArray(arrOfStr);
		return Integer.parseInt(list.get(0));
	}
	 private List<String> removeEmptyfromArray( String []a) {
			List<String> list = new ArrayList<>(Arrays.asList(a));
			list.remove("");
			return list;
	}
 	 public List<String> takeAllTextElements(List<WebElement>a) {
 		 List<String> stringList = new ArrayList<>();
 		 for (WebElement webElement : a) {
 			stringList.add(webElement.getText());
 		}
 			return stringList;
 	}
}
