//
//  DishViewModel.swift
//  SideDish20
//
//  Created by 백상휘 on 2022/04/19.
//

import Foundation
import UIKit

class DishViewModel {
    private let fetchOnComplete: ([UIImage]?) -> Void
    private let fetchCachingImages = FetchCachingImages()
    
    private let cacheImageDataMiddleWare = CacheImageDataMiddleWare()
    
    init(fetchOnComplete: @escaping ([UIImage]?) -> Void) {
        self.fetchOnComplete = fetchOnComplete
    }
    
    func fetchAllCachedImage() {
        fetchCachingImages.fetchCacheImage { result in
            guard let result = result else {
                self.fetchOnComplete(nil)
                return
            }
            
            let images = result.compactMap({ dto in UIImage(data: dto.data)})
            
            guard images.count > 0 else {
                self.fetchOnComplete(nil)
                return
            }
            
            self.fetchOnComplete(images)
        }
    }
    
    func fetchCachedImage(as name: String) {
        fetchCachingImages.fetchCacheImage(as: name) { result in
            guard let result = result, let image = UIImage(data: result.data) else {
                self.fetchOnComplete(nil)
                return
            }
            
            self.fetchOnComplete([image])
        }
    }
    
    func cacheImage(as name: String, contentsOf image: UIImage) {
        guard let data = image.jpegData(compressionQuality: 1.0) else { return }
        cacheImageDataMiddleWare.cacheImage(as: name, contentsOf: data)
        fetchOnComplete([image])
    }
}
