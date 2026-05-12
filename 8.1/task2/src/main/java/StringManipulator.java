class StringManipulator {

	String concatenate(final String str1, final String str2){
		return str1 + str2;
	}

	int findLength(final String str){
		return str.length();
	}

	String toUpper(String str){
		return str.toUpperCase();
	}
	
	String toLower(String str){
		return str.toLowerCase();
	}
	
	boolean containsSubStr(final String str, final String subStr){
		return str.contains(subStr);
	}
}
