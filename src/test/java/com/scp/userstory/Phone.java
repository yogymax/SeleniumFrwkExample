package com.scp.userstory;

import java.util.List;

public class Phone {

		private int landline;
		List<String> mobilesWithCountryCode;
		public int getLandline() {
			return landline;
		}
		public void setLandline(int landline) {
			this.landline = landline;
		}
		public List<String> getMobilesWithCountryCode() {
			return mobilesWithCountryCode;
		}
		public void setMobilesWithCountryCode(List<String> mobilesWithCountryCode) {
			this.mobilesWithCountryCode = mobilesWithCountryCode;
		}
		@Override
		public String toString() {
			return "\nPhone [landline=" + landline + ", mobilesWithCountryCode=" + mobilesWithCountryCode + "]";
		}
		public Phone(int landline, List<String> mobilesWithCountryCode) {
			super();
			this.landline = landline;
			this.mobilesWithCountryCode = mobilesWithCountryCode;
		}
		public Phone() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
		
		
	
}
