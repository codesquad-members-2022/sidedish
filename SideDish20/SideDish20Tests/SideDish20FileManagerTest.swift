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
    }
    
    func test_getAllCached() throws {
        let allFiles = try? getFileURLService.fetchCachedFiles().get()
        let count = allFiles?.count
        
        XCTAssertNotNil(count)
        XCTAssertGreaterThanOrEqual(count!, 0)
    }
    
    func test_viewModel_cacheImage() throws {
        
        guard let data = testImage else {
            XCTFail("TestImage is nil")
            return
        }
        
        let expectation = XCTestExpectation()
        
        let viewModel = CacheViewModel { result in
            if result != nil {
                expectation.fulfill()
            }
        }
        
        viewModel.cacheImage(as: imageName, contentsOf: data)
        wait(for: [expectation], timeout: 3.0)
    }
    
    func test_viewModel_fetchCachedImage() throws {
        
        let expectation = XCTestExpectation()
        
        let viewModel = CacheViewModel { result in
            if result != nil {
                expectation.fulfill()
            }
        }
        
        viewModel.getAllImageCached()
        wait(for: [expectation], timeout: 3.0)
    }
    
    func test_viewModel_cachedData() throws {
        
        let expectation = XCTestExpectation()
        let viewModel = CacheViewModel.init(fetchOnComplete: {_ in })
        
        viewModel.getImage(from: imageName) { image in
            if image != nil {
                expectation.fulfill()
            }
        }
        wait(for: [expectation], timeout: 3.0)
    }
}
