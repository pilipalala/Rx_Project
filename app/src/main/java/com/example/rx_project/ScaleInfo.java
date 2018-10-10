package com.example.rx_project;

/**
 * @author yujie
 * @date on 2018/7/18
 * @describe TODO
 **/
public class ScaleInfo {
    @Override
    public String toString() {
        return "ScaleInfo{" +
                "code=" + code +
                ", details=" + details.toString() +
                ", msg='" + msg + '\'' +
                '}';
    }

    /**
     * code : 0
     * details : {"ageOfBody":27,"bmi":18.3,"bmr":1424,"bodyShape":9,"desirableWeight":63,"fatFreeBodyWeight":49.3,"fatToControl":0,"idealWeight":63,"levelOfVisceralFat":2,"muscleToControl":-4.8,"rateOfBurnFat":{"max":150,"min":112},"ratioOfFat":6.9,"ratioOfMuscle":84.2,"ratioOfProtein":16.2,"ratioOfSubcutaneousFat":-10000,"ratioOfWater":68,"score":63.2,"stateOfNutrition":3,"statusCode":100,"weight":53,"weightOfBone":4.7,"weightOfFat":3.7,"weightOfMuscle":44.6,"weightOfProtein":8.6,"weightOfSkeletalMuscle":31.7,"weightOfWater":36,"weightToControl":-10}
     * msg : success
     */

    private int code;
    private DetailsBean details;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DetailsBean getDetails() {
        return details;
    }

    public void setDetails(DetailsBean details) {
        this.details = details;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DetailsBean {
        @Override
        public String toString() {
            return "DetailsBean{" +
                    "ageOfBody=" + ageOfBody +
                    ", bmi=" + bmi +
                    ", bmr=" + bmr +
                    ", bodyShape=" + bodyShape +
                    ", desirableWeight=" + desirableWeight +
                    ", fatFreeBodyWeight=" + fatFreeBodyWeight +
                    ", fatToControl=" + fatToControl +
                    ", idealWeight=" + idealWeight +
                    ", levelOfVisceralFat=" + levelOfVisceralFat +
                    ", muscleToControl=" + muscleToControl +
                    ", rateOfBurnFat=" + rateOfBurnFat.toString() +
                    ", ratioOfFat=" + ratioOfFat +
                    ", ratioOfMuscle=" + ratioOfMuscle +
                    ", ratioOfProtein=" + ratioOfProtein +
                    ", ratioOfSubcutaneousFat=" + ratioOfSubcutaneousFat +
                    ", ratioOfWater=" + ratioOfWater +
                    ", score=" + score +
                    ", stateOfNutrition=" + stateOfNutrition +
                    ", statusCode=" + statusCode +
                    ", weight=" + weight +
                    ", weightOfBone=" + weightOfBone +
                    ", weightOfFat=" + weightOfFat +
                    ", weightOfMuscle=" + weightOfMuscle +
                    ", weightOfProtein=" + weightOfProtein +
                    ", weightOfSkeletalMuscle=" + weightOfSkeletalMuscle +
                    ", weightOfWater=" + weightOfWater +
                    ", weightToControl=" + weightToControl +
                    '}';
        }

        /**
         * ageOfBody : 27
         * bmi : 18.3
         * bmr : 1424.0
         * bodyShape : 9
         * desirableWeight : 63.0
         * fatFreeBodyWeight : 49.3
         * fatToControl : 0.0
         * idealWeight : 63.0
         * levelOfVisceralFat : 2
         * muscleToControl : -4.8
         * rateOfBurnFat : {"max":150,"min":112}
         * ratioOfFat : 6.9
         * ratioOfMuscle : 84.2
         * ratioOfProtein : 16.2
         * ratioOfSubcutaneousFat : -10000
         * ratioOfWater : 68.0
         * score : 63.2
         * stateOfNutrition : 3
         * statusCode : 100
         * weight : 53.0
         * weightOfBone : 4.7
         * weightOfFat : 3.7
         * weightOfMuscle : 44.6
         * weightOfProtein : 8.6
         * weightOfSkeletalMuscle : 31.7
         * weightOfWater : 36.0
         * weightToControl : -10.0
         */

        private int ageOfBody;
        private double bmi;
        private double bmr;
        private int bodyShape;
        private double desirableWeight;
        private double fatFreeBodyWeight;
        private double fatToControl;
        private double idealWeight;
        private int levelOfVisceralFat;
        private double muscleToControl;
        private RateOfBurnFatBean rateOfBurnFat;
        private double ratioOfFat;
        private double ratioOfMuscle;
        private double ratioOfProtein;
        private int ratioOfSubcutaneousFat;
        private double ratioOfWater;
        private double score;
        private int stateOfNutrition;
        private int statusCode;
        private double weight;
        private double weightOfBone;
        private double weightOfFat;
        private double weightOfMuscle;
        private double weightOfProtein;
        private double weightOfSkeletalMuscle;
        private double weightOfWater;
        private double weightToControl;

        public int getAgeOfBody() {
            return ageOfBody;
        }

        public void setAgeOfBody(int ageOfBody) {
            this.ageOfBody = ageOfBody;
        }

        public double getBmi() {
            return bmi;
        }

        public void setBmi(double bmi) {
            this.bmi = bmi;
        }

        public double getBmr() {
            return bmr;
        }

        public void setBmr(double bmr) {
            this.bmr = bmr;
        }

        public int getBodyShape() {
            return bodyShape;
        }

        public void setBodyShape(int bodyShape) {
            this.bodyShape = bodyShape;
        }

        public double getDesirableWeight() {
            return desirableWeight;
        }

        public void setDesirableWeight(double desirableWeight) {
            this.desirableWeight = desirableWeight;
        }

        public double getFatFreeBodyWeight() {
            return fatFreeBodyWeight;
        }

        public void setFatFreeBodyWeight(double fatFreeBodyWeight) {
            this.fatFreeBodyWeight = fatFreeBodyWeight;
        }

        public double getFatToControl() {
            return fatToControl;
        }

        public void setFatToControl(double fatToControl) {
            this.fatToControl = fatToControl;
        }

        public double getIdealWeight() {
            return idealWeight;
        }

        public void setIdealWeight(double idealWeight) {
            this.idealWeight = idealWeight;
        }

        public int getLevelOfVisceralFat() {
            return levelOfVisceralFat;
        }

        public void setLevelOfVisceralFat(int levelOfVisceralFat) {
            this.levelOfVisceralFat = levelOfVisceralFat;
        }

        public double getMuscleToControl() {
            return muscleToControl;
        }

        public void setMuscleToControl(double muscleToControl) {
            this.muscleToControl = muscleToControl;
        }

        public RateOfBurnFatBean getRateOfBurnFat() {
            return rateOfBurnFat;
        }

        public void setRateOfBurnFat(RateOfBurnFatBean rateOfBurnFat) {
            this.rateOfBurnFat = rateOfBurnFat;
        }

        public double getRatioOfFat() {
            return ratioOfFat;
        }

        public void setRatioOfFat(double ratioOfFat) {
            this.ratioOfFat = ratioOfFat;
        }

        public double getRatioOfMuscle() {
            return ratioOfMuscle;
        }

        public void setRatioOfMuscle(double ratioOfMuscle) {
            this.ratioOfMuscle = ratioOfMuscle;
        }

        public double getRatioOfProtein() {
            return ratioOfProtein;
        }

        public void setRatioOfProtein(double ratioOfProtein) {
            this.ratioOfProtein = ratioOfProtein;
        }

        public int getRatioOfSubcutaneousFat() {
            return ratioOfSubcutaneousFat;
        }

        public void setRatioOfSubcutaneousFat(int ratioOfSubcutaneousFat) {
            this.ratioOfSubcutaneousFat = ratioOfSubcutaneousFat;
        }

        public double getRatioOfWater() {
            return ratioOfWater;
        }

        public void setRatioOfWater(double ratioOfWater) {
            this.ratioOfWater = ratioOfWater;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public int getStateOfNutrition() {
            return stateOfNutrition;
        }

        public void setStateOfNutrition(int stateOfNutrition) {
            this.stateOfNutrition = stateOfNutrition;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public double getWeightOfBone() {
            return weightOfBone;
        }

        public void setWeightOfBone(double weightOfBone) {
            this.weightOfBone = weightOfBone;
        }

        public double getWeightOfFat() {
            return weightOfFat;
        }

        public void setWeightOfFat(double weightOfFat) {
            this.weightOfFat = weightOfFat;
        }

        public double getWeightOfMuscle() {
            return weightOfMuscle;
        }

        public void setWeightOfMuscle(double weightOfMuscle) {
            this.weightOfMuscle = weightOfMuscle;
        }

        public double getWeightOfProtein() {
            return weightOfProtein;
        }

        public void setWeightOfProtein(double weightOfProtein) {
            this.weightOfProtein = weightOfProtein;
        }

        public double getWeightOfSkeletalMuscle() {
            return weightOfSkeletalMuscle;
        }

        public void setWeightOfSkeletalMuscle(double weightOfSkeletalMuscle) {
            this.weightOfSkeletalMuscle = weightOfSkeletalMuscle;
        }

        public double getWeightOfWater() {
            return weightOfWater;
        }

        public void setWeightOfWater(double weightOfWater) {
            this.weightOfWater = weightOfWater;
        }

        public double getWeightToControl() {
            return weightToControl;
        }

        public void setWeightToControl(double weightToControl) {
            this.weightToControl = weightToControl;
        }

        public static class RateOfBurnFatBean {
            /**
             * max : 150
             * min : 112
             */

            private int max;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }

            @Override
            public String toString() {
                return "RateOfBurnFatBean{" +
                        "max=" + max +
                        ", min=" + min +
                        '}';
            }
        }
    }
}
