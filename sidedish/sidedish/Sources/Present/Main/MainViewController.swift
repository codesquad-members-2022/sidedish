//
//  MainViewController.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/18.
//
import Combine
import UIKit

class MainViewController: UIViewController {
    let model: MainViewModelBinding = MainViewModel()
    private var cancellables = Set<AnyCancellable>()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        bind()
        attritbute()
        layout()
    
        model.action.loadData.send() // loadData 호출 (이벤트가 발생했다!)
        
    }
    
    private func bind() {
        model.state.loadedData
            .sink { index in
                print(index)
            } .store(in: &cancellables)
    }
    
    private func attritbute() {
        title = "asfdsafas"
        view.backgroundColor = .red
    }
    
    private func layout() {
        
    }
}
