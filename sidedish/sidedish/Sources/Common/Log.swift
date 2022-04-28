//
//  Log.swift
//  Drawingapp
//
//  Created by seongha shin on 2022/02/28.
//

import Foundation
import OSLog

enum Log {
    
    //Error케이스와 유사하지만, 에러 설명이 긴 경우
    static func info(_ message: String) {
        printLog(logType: .info, message: message)
    }
    
    //개발 환경에서의 간단한 로깅 (mac의 '콘솔'앱에는 찍히지 않고 xcode console에만 표출)
    static func debug(_ message: String) {
        printLog(logType: .debug, message: message)
    }
    
    static func fault(_ message: String) {
        printLog(logType: .fault, message: message)
    }
    
    //문제 해결을 위한 level
    static func print(_ message: String) {
        printLog(logType: .default, message: message)
    }
    
    //Info케이스와 유사하지만, 간단한 에러인 경우
    static func error(_ message: String) {
        printLog(logType: .error, message: message)
    }
    
    private static func printLog(logType: OSLogType, message: String) {
        os_log(logType, log: .default, "\(message)")
    }
}
