package app.sef.entities;

public class Company {
    //@JsonProperty("Ticker")
	private String ticker;
    //@JsonProperty("Name")
	private String name;
    //@JsonProperty("Industry")
	private String industry;
    //@JsonProperty("PE")
	private String pe;
    //@JsonProperty("DIV")
	private String div;
    //@JsonProperty("ROIC")
	private String roic;
	
	
	
	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getPe() {
		return pe;
	}

	public void setPe(String pe) {
		this.pe = pe;
	}

	public String getDiv() {
		return div;
	}

	public void setDiv(String div) {
		this.div = div;
	}

	public String getRoic() {
		return roic;
	}

	public void setRoic(String roic) {
		this.roic = roic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ticker == null) ? 0 : ticker.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (ticker == null) {
			if (other.ticker != null)
				return false;
		} else if (!ticker.equals(other.ticker))
			return false;
		return true;
	}
	
	
	
}
