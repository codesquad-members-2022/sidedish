//
//  SideDish20FileManagerTest.swift
//  SideDish20Tests
//
//  Created by 백상휘 on 2022/04/19.
//

import XCTest
@testable import SideDish20

class SideDish20FileManagerTest: XCTestCase {
    
    let cacheFileManagerAttribute = CacheFileManagerAttribute()
    let saveFileService = SaveFileService()
    let getFileURLService = GetFileURLService()
    
    let imageName = "img01"
    lazy var testImage = UIImage(named: imageName)
    
    func test_CommonAttribute_getCacheDirectoryPath() throws {
        XCTAssertNotNil(cacheFileManagerAttribute.getLibraryPath())
        XCTAssertNotNil(cacheFileManagerAttribute.getCacheDirPath())
    }
    
    func test_SaveFile_returnSavedURL() throws {
        if let data = testImage?.jpegData(compressionQuality: 0.1) {
            XCTAssertNotNil(saveFileService.saveFile(as: "img01", contentsOf: data))
        } else {
            XCTFail("Manipulate UIImage data failed.")
        }
    }
    
    func test_getFileURL() throws {
        let imageURL = getFileURLService.fetchFile(as: imageName)
        XCTAssertNotNil(imageURL)
        let data = try? Data(contentsOf: imageURL!)
        XCTAssertNotNil(data)
    }
    
    func test_getAllCached() throws {
        let allFiles = getFileURLService.fetchCachedFiles()
        XCTAssertGreaterThan(allFiles.count, 0)
    }
}
