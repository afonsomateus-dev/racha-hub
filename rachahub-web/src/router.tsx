import { createBrowserRouter } from "react-router";
import App from "./App";
import { HomeScreen } from "./pages/HomeScreen";
import { MatchesScreen } from "./pages/MatchesScreen";
import { RankingsScreen } from "./pages/RankingsScreen";
import { PlayersScreen } from "./pages/PlayersScreen";

export const router = createBrowserRouter([
  {
    path: "/",
    Component: App,
    children: [
      { index: true, Component: HomeScreen },
      { path: "matches", Component: MatchesScreen },
      { path: "rankings", Component: RankingsScreen },
      { path: "players", Component: PlayersScreen }
    ]
  },
]);