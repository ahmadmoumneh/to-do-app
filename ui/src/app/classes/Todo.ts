import { Category } from "./Category";
import { User } from "./User";

export class Todo {
  id: number;
  name: string;
  description: string;
  done: boolean;
  category: Category;
  user: User;
}