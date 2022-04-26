//
//  DishViewModel.swift
//  SideDish20
//
//  Created by 백상휘 on 2022/04/19.
//

import Foundation
import UIKit

class DishViewModel {
    
    func getAllImageCached(onComplete: @escaping ([UIImage]?) -> Void) {
        
        let middleWare = MiddleWareFactory.make(useCase: .getCacheData)
        
        if let result = middleWare.callCacheSystem(userInfo: nil) as? [Data] {
            
            let images = result.compactMap({ UIImage(data: $0) })
            onComplete(images)
        }
    }
    
    func getImageCached(as name: String, onComplete: @escaping (UIImage?) -> Void) {
        
        let middleWare = MiddleWareFactory.make(useCase: .getCacheData)
        
        if let data = middleWare.callCacheSystem(userInfo: ["name": name]) as? Data {
            onComplete(UIImage(data: data))
            return
        }
        
        onComplete(nil)
    }
    
    func cacheImage(
        as name: String,
        contentsOf image: UIImage,
        onComplete: ((UIImage?) -> Void)? = nil
    ) {
        
        guard let data = image.jpegData(compressionQuality: 1.0) else { return }
        
        let middleWare = MiddleWareFactory.make(useCase: .setCacheIndividually)
        
        if middleWare.callCacheSystem(userInfo: ["name": name, "data": data]) != nil {
            onComplete?(image)
        }
    }
    
    func getImage(from urlString: String, onComplete: @escaping (UIImage?) -> Void) {
        
        guard let url = URL(string: urlString) else {
            onComplete(nil)
            return
        }
        
        URLSession.shared.dataTask(with: url) { [weak self] data, _, error in
            
            guard let self = self else {
                return
            }
            
            guard error == nil, let data = data, let image = UIImage(data: data) else {
                onComplete(nil)
                return
            }
            
            self.cacheImage(as: url.lastPathComponent, contentsOf: image)
            onComplete(image)
            
        }.resume()
    }
}
