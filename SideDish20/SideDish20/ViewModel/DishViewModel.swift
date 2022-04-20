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
    
    func fetchCachedImage(as name: String, fetchImageHandler: @escaping (UIImage?) -> Void) {
        fetchCachingImages.fetchCacheImage(as: name) { result in
            guard let result = result else {
                fetchImageHandler(nil)
                return
            }
            
            fetchImageHandler(UIImage(data: result.data))
        }
    }
    
    func cacheImage(as name: String, contentsOf image: UIImage) {
        guard let data = image.jpegData(compressionQuality: 1.0) else { return }
        cacheImageDataMiddleWare.cacheImage(as: name, contentsOf: data)
        fetchOnComplete([image])
    }
    
    func getImage(from urlString: String, getImageHandler: @escaping (UIImage?) -> Void) {
        guard let url = URL(string: urlString) else {
            getImageHandler(nil)
            return
        }
        
        fetchCachedImage(as: url.lastPathComponent) { image in
            if let image = image {
                getImageHandler(image)
                return
            }
            
            URLSession.shared.dataTask(with: url) { data, response, error in
                guard error == nil, let data = data else {
                    getImageHandler(nil)
                    return
                }
                
                let image = UIImage(data: data)
                getImageHandler(image)
                
                if let image = image {
                    self.cacheImage(as: url.lastPathComponent, contentsOf: image)
                }
                
            }.resume()
        }
    }
}
