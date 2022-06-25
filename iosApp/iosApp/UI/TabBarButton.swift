//
//  TabBarView.swift
//  iosApp
//
//  Created by Batuhan Simsek on 24.06.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct Tab {
    var title: String
}

struct TabBarButton: View {
    var fixed = true
    var tabs: [Tab]
    var geoWidth: CGFloat
    @Binding var selectedTab: Int
    
    //TODO: fix theme
    var body: some View {
        ScrollView(.horizontal, showsIndicators: false) {
            ScrollViewReader { proxy in
                VStack(spacing: 0) {
                    HStack(spacing: 0) {
                        ForEach(0 ..< tabs.count, id: \.self) { row in
                            Button(action: {
                                withAnimation{
                                    selectedTab = row
                                }
                            }, label: {
                                VStack(spacing: 0) {
                                    Text(tabs[row].title)
                                        .font(Font.system(size: 18, weight: .semibold))
                                        .foregroundColor(Color(UIColor.white))
                                        .padding(EdgeInsets(top: 10, leading: 3, bottom: 10, trailing: 15))
                                        .frame(width: fixed ? (geoWidth / CGFloat(tabs.count)) : .none, height: 52)
                                    // Bar Indicator
                                    Rectangle().fill(selectedTab == row ? Color(UIColor.white) : Color.clear)
                                        .frame(height: 3)
                                }.fixedSize()
                            })
                                .accentColor(Color(UIColor.white))
                                .buttonStyle(PlainButtonStyle())
                        }
                    }
                    .onChange(of: selectedTab) { target in
                        withAnimation {
                            proxy.scrollTo(target)
                        }
                    }
                    .background(Color(UIColor.secondarySystemBackground))
                }
            }
        }
        .frame(height: 55)
        .onAppear(perform: {
            //UIScrollView.appearance().backgroundColor = UIColor(.white)
            UIScrollView.appearance().bounces = fixed ? false : true
        })
        .onDisappear(perform: {
            UIScrollView.appearance().bounces = true
        })
    }
}
