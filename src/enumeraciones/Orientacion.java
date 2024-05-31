package enumeraciones;

public enum Orientacion {
	NORTE{
		public String getOrientation() {
			return "Norte";
		}
	},
	SUR{
		public String getOrientation() {
			return "Sur";
		}
	},
	ESTE{
		public String getOrientation() {
			return "ESTE";
		}
	},
	OESTE{
		public String getOrientation() {
			return "OESTE";
		}
	};
	public abstract String getOrientation();
}
