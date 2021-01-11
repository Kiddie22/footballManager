export interface IClub {
  nameOfClub: string;
  city: string;
  wins: number;
  defeats: number;
  draws: number;
  goalsReceived: number;
  goalsScored: number;
  points: number;
  numberOfMatchesPlayed: number;
  goalDifference: number;
  universityName?: string;
  universityId?: number;
  schoolName?: string;
  schoolId?: number;
}