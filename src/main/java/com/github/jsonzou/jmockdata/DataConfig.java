package com.github.jsonzou.jmockdata;

import com.github.jsonzou.jmockdata.util.Xeger;

/**
 * @Author: jsonzou
 * @Date: 2018/10/29 13:24
 * @Description:
 */
public class DataConfig {
    private MockConfig config;
    private byte[] byteRange = {0, 127};
    private boolean[] booleanSeed = {true, false};
    private short[] shortRange = {0, 1000};
    private int[] intRange = {0, 1_000_000_000};
    private float[] floatRange = {0.0f, 1_000_000_000.00f};
    private double[] doubleRange = {0.0, 1_000_000_000.00};
    private long[] longRange = {0L, 1_000_000_000L};
    private String[] dateRange = {"1970-01-01", "2100-12-31"};
    private int[] sizeRange = {1, 10};

    private char[] charSeed =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                    'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F',
                    'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private String[] stringSeed =
            {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                    "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F",
                    "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    private String numberRegex = null;
    private String stringRegex = null;
    private Xeger numberXeger = null;
    private Xeger stringXeger = null;

    public DataConfig(MockConfig config) {
        this.config = config;
    }

    /**
     * 配置转路器 - 设置全局配置
     * @return
     */
    public MockConfig globalConfig(){
        return this.config;
    }

    /**
     * 配置转路器 - 切换设置全局字段模拟配置
     * @return
     */
    public DataConfig subConfig(String... fieldNames){
        return this.config.subConfig(fieldNames);
    }

    /**
     * 配置转路器 - 设置局部配置
     * @return
     */
    public DataConfig subConfig(Class<?> clazz,String... fieldName){
        return this.config.subConfig(clazz,fieldName);
    }

    public DataConfig byteRange(byte min, byte max) {
        if(min<Byte.MIN_VALUE || max >Byte.MAX_VALUE){
            throw new MockException("Out Of The Range Of Byte Data.");
        }
        this.byteRange[0] = min;
        this.byteRange[1] = max;
        return this;
    }
    public DataConfig booleanSeed(boolean... booleanSeed) {
        this.booleanSeed = booleanSeed;
        return this;
    }

    public DataConfig shortRange(short min, short max) {
        if(min<Short.MIN_VALUE || max >Short.MAX_VALUE){
            throw new MockException("Out Of The Range Of Short Data.");
        }
        this.shortRange[0] = min;
        this.shortRange[1] = max;
        return this;
    }

    public DataConfig intRange(int min, int max) {
        if(min<Integer.MIN_VALUE || max >Integer.MAX_VALUE){
            throw new MockException("Out Of The Range Of Integer Data.");
        }
        this.intRange[0] = min;
        this.intRange[1] = max;
        return this;
    }

    public DataConfig floatRange(float min, float max) {
        if(min<Float.MIN_VALUE || max >Float.MAX_VALUE){
            throw new MockException("Out Of The Range Of Float Data.");
        }
        this.floatRange[0] = min;
        this.floatRange[1] = max;
        return this;
    }

    public DataConfig doubleRange(double min, double max) {
        if(min<Double.MIN_VALUE || max >Double.MAX_VALUE){
            throw new MockException("Out Of The Range Of Double Data.");
        }
        this.doubleRange[0] = min;
        this.doubleRange[1] = max;
        return this;
    }

    public DataConfig longRange(long min, long max) {
        if(min<Long.MIN_VALUE || max >Long.MAX_VALUE){
            throw new MockException("Out Of The Range Of Long Data.");
        }
        this.longRange[0] = min;
        this.longRange[1] = max;
        return this;
    }

    public DataConfig dateRange(String min, String max) {
        this.dateRange[0] = min;
        this.dateRange[1] = max;
        return this;
    }

    public DataConfig sizeRange(int min, int max) {
        if(min<Integer.MIN_VALUE || max >Integer.MAX_VALUE){
            throw new MockException("The Size Is Out Of The Range Of Integer Data.");
        }
        this.sizeRange[0] = min;
        this.sizeRange[1] = max;
        return this;
    }

    public DataConfig stringSeed(String... stringSeed) {
        this.stringSeed = stringSeed;
        return this;
    }

    public DataConfig charSeed(char... charSeed) {
        this.charSeed = charSeed;
        return this;
    }
    public DataConfig numberXeger(String numberRegex) {
        this.numberRegex = numberRegex;
        this.numberXeger = new Xeger(numberRegex);
        return this;
    }
    public DataConfig stringXeger(String stringRegex) {
        this.stringRegex = stringRegex;
        this.stringXeger = new Xeger(stringRegex);
        return this;
    }


    public byte[] byteRange() {
        return this.byteRange;
    }
    public boolean[] booleanSeed() {
        return this.booleanSeed;
    }

    public short[] shortRange() {
        return this.shortRange;
    }

    public int[] intRange() {
        return this.intRange;
    }

    public float[] floatRange() {
        return this.floatRange;
    }

    public double[] doubleRange() {
        return this.doubleRange;
    }

    public long[] longRange() {
        return this.longRange;
    }

    public String[] dateRange() {
        return  this.dateRange;
    }

    public int[] sizeRange() {
        return this.sizeRange;
    }

    public String[] stringSeed() {
        return this.stringSeed;
    }

    public char[] charSeed() {
        return this.charSeed;
    }
    public Xeger numberXeger() {
       return this.numberXeger ;
    }
    public Xeger stringXeger() {
       return this.stringXeger ;
    }

}
