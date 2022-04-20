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
    
    private let cacheImageRequestMiddleWare = CacheImageRequestMiddleWare()
    private let cacheImageMiddleWare = CacheImageMiddleWare()
    
    init(fetchOnComplete: @escaping ([UIImage]?) -> Void) {
        self.fetchOnComplete = fetchOnComplete
    }
    
    func getAllImageCached() {
        cacheImageRequestMiddleWare.getAllImageDataCached { result in
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
    
    func getImageCached(
        as name: String,
        fetchImageHandler: @escaping (UIImage?) -> Void
    ) {
        
        cacheImageRequestMiddleWare.getImageDataCached(as: name) { result in
            guard let result = result else {
                fetchImageHandler(nil)
                return
            }
            
            fetchImageHandler(UIImage(data: result.data))
        }
    }
    
    func cacheImage(
        as name: String,
        contentsOf image: UIImage
    ) {
        
        guard let data = image.jpegData(compressionQuality: 1.0) else {
            return
        }
        cacheImageMiddleWare.cacheImage(as: name, contentsOf: data)
        fetchOnComplete([image])
    }
    
    func getImage(
        from urlString: String,
        getImageHandler: @escaping (UIImage?) -> Void
    ) {
        
        // 캐시한 이미지는 url의 lastPathComponent로 저장하는 것에 의미가 있기 때문에 전달되는 urlString은 URL로 구성되어야 한다.
        guard let url = URL(string: urlString) else {
            getImageHandler(nil)
            return
        }
        
        let cacheName = url.lastPathComponent
        
        getImageCached(as: cacheName) { image in
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
                    self.cacheImage(as: cacheName, contentsOf: image)
                }
                
            }.resume()
        }
    }
}
