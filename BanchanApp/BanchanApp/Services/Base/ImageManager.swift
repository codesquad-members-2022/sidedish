//
//  ImageManager.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/27.
//

import Foundation

class ImageData {
	var data: Data

	init(data: Data) {
		self.data = data
	}
}

class ImageManager {
	private let cachedImages = NSCache<NSURL, ImageData>()
	private var pendingResponses = [NSURL: [(Data) -> Void]]()

	func getImage(url: NSURL) -> ImageData? {
		return cachedImages.object(forKey: url)
	}

	func fetchImage(with url: NSURL, completion: @escaping (Data) -> Void) {
		if let cachedImage = getImage(url: url) {
			completion(cachedImage.data)
			return
		}

		guard pendingResponses[url] == nil else {
			pendingResponses[url]?.append(completion)
			return
		}

		pendingResponses[url] = [completion]

		URLSession.shared.dataTask(with: url as URL) { data, _, error in
			guard
				let data = data, error == nil, let completions = self.pendingResponses[url] else { return }

			let imageData = ImageData(data: data)
			self.cachedImages.setObject(imageData, forKey: url)

			completions.forEach { completion in
				DispatchQueue.main.async {
					completion(imageData.data)
				}
			}

		}.resume()
	}
}
