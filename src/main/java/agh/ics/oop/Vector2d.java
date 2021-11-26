package agh.ics.oop;

import java.util.Objects;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return '(' + String.valueOf(this.x) + ',' + String.valueOf(this.y) + ')';
    }

    public boolean precedes(Vector2d other) {
        if (other.x >= this.x && other.y >= this.y) {
            return true;
        }
        return false;
    }

    public boolean follows(Vector2d other) {
        if (other.x <= this.x && other.y <= this.y) {
            return true;
        }
        return false;
    }

    public Vector2d upperRight(Vector2d other) {
        int newX;
        int newY;
        if (this.x <= other.x) {
            newX = other.x;
        } else {
            newX = this.x;
        }

        if (this.y <= other.y) {
            newY = other.y;
        } else {
            newY = this.y;
        }
        return new Vector2d(newX, newY);
    }

    public Vector2d lowerLeft(Vector2d other) {
        int newX;
        int newY;
        if (this.x > other.x) {
            newX = other.x;
        } else {
            newX = this.x;
        }

        if (this.y > other.y) {
            newY = other.y;
        } else {
            newY = this.y;
        }
        return new Vector2d(newX, newY);
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        if (this.x == that.x && this.y == that.y) {
            return true;
        }
        return false;
    }

    public Vector2d opposite() {
        return new Vector2d((-1) * this.x, (-1) * this.y);
    }

    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }
}

