type token =
  | VAL of (
# 8 "parser.mly"
        Ast.value
# 6 "parser.ml"
)
  | ID of (
# 9 "parser.mly"
        string
# 11 "parser.ml"
)
  | PLUS
  | LPAR
  | RPAR
  | TERM
  | TIME
  | MINUS

open Parsing
let _ = parse_error;;
# 2 "parser.mly"

open Ast

# 26 "parser.ml"
let yytransl_const = [|
  259 (* PLUS *);
  260 (* LPAR *);
  261 (* RPAR *);
  262 (* TERM *);
  263 (* TIME *);
  264 (* MINUS *);
    0|]

let yytransl_block = [|
  257 (* VAL *);
  258 (* ID *);
    0|]

let yylhs = "\255\255\
\001\000\001\000\002\000\002\000\002\000\002\000\002\000\002\000\
\002\000\000\000"

let yylen = "\002\000\
\002\000\002\000\001\000\001\000\003\000\003\000\003\000\002\000\
\003\000\002\000"

let yydefred = "\000\000\
\000\000\000\000\003\000\004\000\000\000\000\000\000\000\010\000\
\000\000\000\000\001\000\008\000\000\000\002\000\000\000\000\000\
\009\000\000\000\007\000\000\000"

let yydgoto = "\002\000\
\008\000\009\000"

let yysindex = "\002\000\
\011\255\000\000\000\000\000\000\019\255\011\255\019\255\000\000\
\254\254\021\255\000\000\000\000\019\255\000\000\019\255\019\255\
\000\000\000\255\000\000\000\255"

let yyrindex = "\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\027\255\000\000\031\255"

let yygindex = "\000\000\
\003\000\251\255"

let yytablesize = 39
let yytable = "\010\000\
\013\000\012\000\001\000\014\000\015\000\016\000\015\000\018\000\
\011\000\019\000\020\000\003\000\004\000\000\000\005\000\000\000\
\006\000\000\000\007\000\003\000\004\000\000\000\005\000\013\000\
\000\000\017\000\007\000\015\000\016\000\006\000\000\000\006\000\
\006\000\005\000\006\000\005\000\005\000\000\000\005\000"

let yycheck = "\005\000\
\003\001\007\000\001\000\006\001\007\001\008\001\007\001\013\000\
\006\000\015\000\016\000\001\001\002\001\255\255\004\001\255\255\
\006\001\255\255\008\001\001\001\002\001\255\255\004\001\003\001\
\255\255\005\001\008\001\007\001\008\001\003\001\255\255\005\001\
\006\001\003\001\008\001\005\001\006\001\255\255\008\001"

let yynames_const = "\
  PLUS\000\
  LPAR\000\
  RPAR\000\
  TERM\000\
  TIME\000\
  MINUS\000\
  "

let yynames_block = "\
  VAL\000\
  ID\000\
  "

let yyact = [|
  (fun _ -> failwith "parser")
; (fun __caml_parser_env ->
    let _2 = (Parsing.peek_val __caml_parser_env 0 : Ast.expr) in
    Obj.repr(
# 30 "parser.mly"
                            ( _2 )
# 106 "parser.ml"
               : Ast.expr))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 1 : 'expr) in
    Obj.repr(
# 31 "parser.mly"
                            ( _1 )
# 113 "parser.ml"
               : Ast.expr))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : Ast.value) in
    Obj.repr(
# 35 "parser.mly"
                            ( ECst _1 )
# 120 "parser.ml"
               : 'expr))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : string) in
    Obj.repr(
# 36 "parser.mly"
                            ( EId _1 )
# 127 "parser.ml"
               : 'expr))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 2 : 'expr) in
    let _3 = (Parsing.peek_val __caml_parser_env 0 : 'expr) in
    Obj.repr(
# 37 "parser.mly"
                            ( EAdd (_1, ENeg(_3)) )
# 135 "parser.ml"
               : 'expr))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 2 : 'expr) in
    let _3 = (Parsing.peek_val __caml_parser_env 0 : 'expr) in
    Obj.repr(
# 38 "parser.mly"
                            ( EAdd (_1, _3) )
# 143 "parser.ml"
               : 'expr))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 2 : 'expr) in
    let _3 = (Parsing.peek_val __caml_parser_env 0 : 'expr) in
    Obj.repr(
# 39 "parser.mly"
                            ( EMul (_1, _3) )
# 151 "parser.ml"
               : 'expr))
; (fun __caml_parser_env ->
    let _2 = (Parsing.peek_val __caml_parser_env 0 : 'expr) in
    Obj.repr(
# 40 "parser.mly"
                            ( ENeg _2 )
# 158 "parser.ml"
               : 'expr))
; (fun __caml_parser_env ->
    let _2 = (Parsing.peek_val __caml_parser_env 1 : 'expr) in
    Obj.repr(
# 41 "parser.mly"
                            ( _2 )
# 165 "parser.ml"
               : 'expr))
(* Entry ansyn *)
; (fun __caml_parser_env -> raise (Parsing.YYexit (Parsing.peek_val __caml_parser_env 0)))
|]
let yytables =
  { Parsing.actions=yyact;
    Parsing.transl_const=yytransl_const;
    Parsing.transl_block=yytransl_block;
    Parsing.lhs=yylhs;
    Parsing.len=yylen;
    Parsing.defred=yydefred;
    Parsing.dgoto=yydgoto;
    Parsing.sindex=yysindex;
    Parsing.rindex=yyrindex;
    Parsing.gindex=yygindex;
    Parsing.tablesize=yytablesize;
    Parsing.table=yytable;
    Parsing.check=yycheck;
    Parsing.error_function=parse_error;
    Parsing.names_const=yynames_const;
    Parsing.names_block=yynames_block }
let ansyn (lexfun : Lexing.lexbuf -> token) (lexbuf : Lexing.lexbuf) =
   (Parsing.yyparse yytables 1 lexfun lexbuf : Ast.expr)
