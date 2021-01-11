export interface Date {
    day: number;
    month: number;
    year: number;
}

export interface IMatch {
    teamOne: string;
    teamTwo: string;
    teamOneGoals: number;
    teamTwoGoals: number;
    date: Date;
}