import 'dart:async';

import 'package:flutter/services.dart';

class FirstPlugin {
  static const MethodChannel _channel =
      const MethodChannel('first_plugin');

  Future<String> launchTruePhone(int idActivity) async {
    await _channel.invokeMethod('launchTruePhone', <String, dynamic>{
      'idActivity': idActivity,
    });
  }




}
