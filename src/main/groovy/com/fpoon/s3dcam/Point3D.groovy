package com.fpoon.s3dcam

import groovy.transform.InheritConstructors;

@InheritConstructors
class Point3D extends Point {
    double x,y,z;

    Point3D(double x, double y, double z) {
        this.x = x
        this.y = y
        this.z = z
    }
}
