package com.mps.think.setup.vo;

public class SourceFormatSegmentVo {

	private Integer id;

	private SourceAttributesVO sourceAttribute;

//	@Enumerated(EnumType.STRING)
//	private AppConstants.GenerationMethod generationMethod;
	private String generationMethod;

	private String fixedValue;

	private String genFuncParm;

	private Integer demQuestionId;

//	@Enumerated(EnumType.STRING)
//	private AppConstants.GenerationFunction generationFunction;
	private String generationFunction;
	
	private SourceFormatVo SourceFormatVo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SourceAttributesVO getSourceAttribute() {
		return sourceAttribute;
	}

	public void setSourceAttribute(SourceAttributesVO sourceAttribute) {
		this.sourceAttribute = sourceAttribute;
	}

	public String getGenerationMethod() {
		return generationMethod;
	}

	public void setGenerationMethod(String generationMethod) {
		this.generationMethod = generationMethod;
	}

	public String getFixedValue() {
		return fixedValue;
	}

	public void setFixedValue(String fixedValue) {
		this.fixedValue = fixedValue;
	}

	public String getGenFuncParm() {
		return genFuncParm;
	}

	public void setGenFuncParm(String genFuncParm) {
		this.genFuncParm = genFuncParm;
	}

	public Integer getDemQuestionId() {
		return demQuestionId;
	}

	public void setDemQuestionId(Integer demQuestionId) {
		this.demQuestionId = demQuestionId;
	}

	public String getGenerationFunction() {
		return generationFunction;
	}

	public void setGenerationFunction(String generationFunction) {
		this.generationFunction = generationFunction;
	}

	public SourceFormatVo getSourceFormatVo() {
		return SourceFormatVo;
	}

	public void setSourceFormatVo(SourceFormatVo sourceFormatVo) {
		SourceFormatVo = sourceFormatVo;
	}

	
	
}