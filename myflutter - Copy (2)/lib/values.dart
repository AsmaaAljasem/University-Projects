import 'package:flutter/material.dart';

class MyElement extends AssetImage {
  static const AssetImage m1 = AssetImage("images/Agriculture.jpg");
  static const AssetImage m2 = AssetImage("images/Chemical.jpg");
  static const AssetImage m3 = AssetImage("images/Electronics.jpg");
  static const AssetImage m4 = AssetImage("images/Food.jpg");
  static const AssetImage m5 = AssetImage("images/Sewing.jpg");
  static const AssetImage m6 = AssetImage("images/Education.jpg");

  static const Map<String, AssetImage> myImages = {
    "Agriculture": m1,
    "Chemical": m2,
    "Electronics": m3,
    "Food": m4,
    "Sewing": m5,
    "Education": m6
  };

  MyElement(super.assetName);
}
