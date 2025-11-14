(* Syntaxe abstraite *)
type value = 
  | VInt of int
  | VBool of bool
  | VFloat of float
  | VString of string

type expr =
  | ECst of value
  | EId of string
  | EAdd of expr * expr
  | EMul of expr * expr
  | ENeg of expr

(* Conversion en chaîne de caractères pour affichage *)
let rec string_of_value e = match e with
  | VInt i -> string_of_int i
  | VBool b -> string_of_bool b
  | VString s ->  s
  | VFloat f -> string_of_float f


let rec string_of_expr e = match e with
  | ECst i -> string_of_value i
  | EId s -> Printf.sprintf "ID: %s" s
  | EAdd (e1, e2) -> Printf.sprintf "(%s) + (%s)" (string_of_expr e1) (string_of_expr e2)
  | EMul (e1, e2) -> Printf.sprintf "(%s) * (%s)" (string_of_expr e1) (string_of_expr e2)
  | ENeg (e1) -> Printf.sprintf "-(%s)" (string_of_expr e1)

