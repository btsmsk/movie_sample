import SwiftUI
import shared

struct MainScreen: View {
    @State private var selectedTab: Int = 0
    
    let tabs: [Tab] = [
        .init(title: "Playing"),
        .init(title: "Upcoming")
    ]
    
    init() {
        let navbarAppearance = UINavigationBarAppearance()
                navbarAppearance.largeTitleTextAttributes = [.foregroundColor: UIColor.white]
                navbarAppearance.titleTextAttributes = [.foregroundColor: UIColor.white]
        navbarAppearance.backgroundColor = UIColor.systemBackground
        UINavigationBar.appearance().isTranslucent = false
    }
    
    var body: some View {
        NavigationView{
            GeometryReader { geo in
                VStack(spacing: 0) {
                    TabBarButton(tabs: tabs, geoWidth: geo.size.width, selectedTab: $selectedTab)
                    
                    // Views
                    TabView(selection: $selectedTab,
                            content: {
                        NowPlayingMoviesScreen()
                            .tag(0)
                        UpcomingMoviesScreen()
                            .tag(1)
                    }).tabViewStyle(PageTabViewStyle(indexDisplayMode: .never))
                }
            }
            .navigationBarTitleDisplayMode(.inline)
            .navigationBarTitle("The Movies")
        }.accentColor(.yellow)
    }
}

struct MainScreen_Previews: PreviewProvider {
    static var previews: some View {
        MainScreen()
    }
}
