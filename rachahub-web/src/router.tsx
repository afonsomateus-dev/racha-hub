import { createBrowserRouter } from "react-router";
import App from "./App";
import { HomeScreen, MatchesScreen, RankingsScreen, PlayerProfileScreen, PlayersScreen } from "@pages";

export const router = createBrowserRouter([
  {
    path: "/",
    Component: App,
    children: [
      { index: true, Component: HomeScreen },
      { path: "matches", Component: MatchesScreen },
      { path: "rankings", Component: RankingsScreen },
      { path: "players", Component: PlayersScreen },
      { path: "players/:playerId", Component: PlayerProfileScreen },
    ]
  },
]);