//
//  DecoderByPropertyWrapper.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/27.
//

import Foundation

protocol DecodableTransformer {
    associatedtype Source: Decodable
    associatedtype Object
    
    static func transform(form decodable: Source) throws -> Object
}

@propertyWrapper
struct DecodedBy<T: DecodableTransformer>: Decodable {
    var wrappedValue: T.Object
    
    init(wrappedValue: T.Object) {
        self.wrappedValue = wrappedValue
    }
    
    init(from decoder: Decoder) throws {
        self.wrappedValue = try Self.decodeObject(type: T.self, decoder: decoder)
    }
    
    private static func decodeObject<T>(type transformer: T.Type, decoder: Decoder) throws -> T.Object where T: DecodableTransformer {
        let source = try T.Source(from: decoder)
        let object = try T.transform(form: source)
        return object
    }
}
