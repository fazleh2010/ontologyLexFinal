/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citec.correlation.wikipedia.dic.lexicon;

import citec.correlation.wikipedia.results.WordResult;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author elahi
 */
public class ResultDetail implements Comparator<ResultDetail>{

    private String pair;
    private Double multiply;
    private String posTag;
    private static String ENTITY_NOTATION = "http://dbpedia.org/resource/";
    private Map<String, Double> probabilities = new TreeMap<String, Double>();

    public ResultDetail(String postag,String property, String objectOfProperty, Double multiply, Map<String, Double> probabilities) {
        this.posTag=postag;
        this.pair = property + " " + this.setObjectOfProperty(objectOfProperty);
        this.multiply = multiply;
        this.probabilities = probabilities;
    }

    public ResultDetail() {
    }

    public String getPair() {
        return pair;
    }

    public void setPosTag(String posTag) {
        this.posTag = posTag;
    }

    public String getPosTag() {
        return posTag;
    }

    public Double getMultiply() {
        return multiply;
    }

    private String setObjectOfProperty(String objectOfProperty) {
        if (objectOfProperty.contains(ENTITY_NOTATION)) {
            objectOfProperty = objectOfProperty.replace(ENTITY_NOTATION, "res:");
        } /*else {
            objectOfProperty = "\"" + objectOfProperty + "\"";
        }*/
        return objectOfProperty;

    }
    
    @Override
    public int compare(ResultDetail entityInfoA, ResultDetail entityInfoB) {
        return Double.compare(entityInfoA.getMultiply(), entityInfoB.getMultiply());
    }

    @Override
    public String toString() {
        return "EntityInfo{" + "pair=" + pair + ", multiply=" + multiply + ", posTag=" + posTag + ", probabilities=" + probabilities + '}';
    }

  

}
