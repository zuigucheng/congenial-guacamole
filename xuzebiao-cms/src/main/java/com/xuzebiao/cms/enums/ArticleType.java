package com.xuzebiao.cms.enums;

public enum ArticleType {
		//文本
		HTML("文本"),
		//图文
		IMAGE("图文");
		
		//信息描述
		private String description;

		//有参构造
		private ArticleType(String description) {
			this.description = description;
		}
		
		/**
		 * 获取枚举信息
		 *
		 */
		public String getDescription() {
			return description;
		}

		public String getName() {
			return name();
		}
		
		public int getOrdinal() {
			return this.ordinal();
		}
}
