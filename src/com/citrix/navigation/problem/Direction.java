package com.citrix.navigation.problem;

public enum Direction {

	North(0,1) {
        @Override
        public Direction left() {
            return West;
        }

        @Override
        public Direction right() {
            return East;
        }
    },

    South(0,-1) {
        @Override
        public Direction right() {
            return West;
        }

        @Override
        public Direction left() {
            return East;
        }
    },

    East(1,0) {
        @Override
        public Direction right() {
            return South;
        }

        @Override
        public Direction left() {
            return North;
        }
    },

    West(-1,0) {
        @Override
        public Direction right() {
            return North;
        }

        @Override
        public Direction left() {
            return South;
        }
    };

    private int stepSizeOnXAxis;
    private int stepSizeOnYAxis;

    Direction(int stepSizeOnXAxis, int stepSizeOnYAxis) {
        this.stepSizeOnXAxis = stepSizeOnXAxis;
        this.stepSizeOnYAxis = stepSizeOnYAxis;
    }

    public abstract Direction right();
    public abstract Direction left();

    public int stepSizeForXAxis() {
        return this.stepSizeOnXAxis;
    }

    public int stepSizeForYAxis() {
        return this.stepSizeOnYAxis;
    }
}
