import { Zap } from "lucide-react";
import { Bar, BarChart, Rectangle, ResponsiveContainer, XAxis, YAxis } from "recharts";
import { MATCHES } from "../../constants";
import type { PlayerGoalsChartProps } from "@types";
import { goalsBy } from "@utils";

export const PlayerGoalsChart = ({ player }: PlayerGoalsChartProps) => {
  const chartData = MATCHES.slice(0, 6).reverse().map((m, i) => ({
    name: `P${i + 1}`,
    gols: goalsBy(m, player.id),
  }));

  return (
    <div className="rounded-2xl p-4" style={{ background: "#141419", border: "1px solid rgba(255,255,255,0.06)" }}>
      <div className="flex items-center gap-2 mb-4">
        <Zap className="w-3.5 h-3.5 text-[#FFB800]" />
        <span className="text-xs font-bold text-white/40 uppercase tracking-widest">Gols por Partida</span>
      </div>
      <ResponsiveContainer width="100%" height={72}>
        <BarChart data={chartData} barSize={20} barCategoryGap="25%">
          <XAxis dataKey="name" tick={{ fill: "#3a3a4a", fontSize: 9 }} axisLine={false} tickLine={false} />
          <YAxis hide />
          <Bar 
            dataKey="gols" 
            radius={[4, 4, 0, 0]}
            shape={(props) => {
              const isGoalScored = props.payload && props.payload.gols > 0;
              
              return (
                <Rectangle 
                  {...props} 
                  fill={isGoalScored ? player.color : "#1e1e28"} 
                />
              );
            }}
          />
        </BarChart>
      </ResponsiveContainer>
    </div>
  );
}