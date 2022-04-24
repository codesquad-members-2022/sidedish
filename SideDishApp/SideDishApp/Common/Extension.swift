//
//  Extension.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/24.
//

import UIKit
extension String {
    func strikeThrough() -> NSAttributedString {
            let attributeString: NSMutableAttributedString = NSMutableAttributedString(string: self)
            attributeString.addAttribute(NSAttributedString.Key.strikethroughStyle, value: NSUnderlineStyle.single.rawValue, range: NSRange(location: 0, length: attributeString.length))
            return attributeString
        }
}
