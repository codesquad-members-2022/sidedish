//
//  ImageRepository.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/22.
//

import Combine
import Foundation

protocol ResourceRepository {
    func loadImage(_ url: URL) -> AnyPublisher<URL, Never>
}
