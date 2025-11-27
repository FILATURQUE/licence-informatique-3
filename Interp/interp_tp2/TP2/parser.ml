type token =
  | INT of (
# 8 "parser.mly"
        int
# 6 "parser.ml"
)
  | FLOAT of (
# 9 "parser.mly"
        float
# 11 "parser.ml"
)
  | STR of (
# 10 "parser.mly"
        string
# 16 "parser.ml"
)
  | TRUE
  | FALSE
  | PLUS
  | MINUS
  | TIMES
  | LPAR
  | RPAR
  | TERM

open Parsing
let _ = parse_error;;
# 2 "parser.mly"

open Ast

# 33 "parser.ml"
let yytransl_const = [|
  260 (* TRUE *);
  261 (* FALSE *);
  262 (* PLUS *);
  263 (* MINUS *);
  264 (* TIMES *);
  265 (* LPAR *);
  266 (* RPAR *);
  267 (* TERM *);
    0|]

let yytransl_block = [|
  257 (* INT *);
  258 (* FLOAT *);
  259 (* STR *);
    0|]

let yylhs = "\255\255\
\001\000\001\000\002\000\002\000\002\000\002\000\002\000\002\000\
\003\000\003\000\003\000\003\000\003\000\000\000"

let yylen = "\002\000\
\002\000\002\000\001\000\003\000\003\000\003\000\002\000\003\000\
\001\000\001\000\001\000\001\000\001\000\002\000"

let yydefred = "\000\000\
\000\000\000\000\009\000\010\000\013\000\011\000\012\000\000\000\
\000\000\000\000\014\000\000\000\003\000\007\000\000\000\001\000\
\000\000\000\000\000\000\002\000\008\000\000\000\000\000\005\000"

let yydgoto = "\002\000\
\011\000\012\000\013\000"

let yysindex = "\004\000\
\011\255\000\000\000\000\000\000\000\000\000\000\000\000\022\255\
\022\255\011\255\000\000\252\254\000\000\000\000\034\255\000\000\
\022\255\022\255\022\255\000\000\000\000\254\254\254\254\000\000"

let yyrindex = "\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\026\255\028\255\000\000"

let yygindex = "\000\000\
\254\255\248\255\000\000"

let yytablesize = 44
let yytable = "\014\000\
\015\000\017\000\018\000\019\000\001\000\019\000\020\000\016\000\
\022\000\023\000\024\000\003\000\004\000\005\000\006\000\007\000\
\000\000\008\000\000\000\009\000\000\000\010\000\003\000\004\000\
\005\000\006\000\007\000\000\000\008\000\000\000\009\000\004\000\
\004\000\006\000\006\000\004\000\004\000\006\000\006\000\017\000\
\018\000\019\000\000\000\021\000"

let yycheck = "\008\000\
\009\000\006\001\007\001\008\001\001\000\008\001\011\001\010\000\
\017\000\018\000\019\000\001\001\002\001\003\001\004\001\005\001\
\255\255\007\001\255\255\009\001\255\255\011\001\001\001\002\001\
\003\001\004\001\005\001\255\255\007\001\255\255\009\001\006\001\
\007\001\006\001\007\001\010\001\011\001\010\001\011\001\006\001\
\007\001\008\001\255\255\010\001"

let yynames_const = "\
  TRUE\000\
  FALSE\000\
  PLUS\000\
  MINUS\000\
  TIMES\000\
  LPAR\000\
  RPAR\000\
  TERM\000\
  "

let yynames_block = "\
  INT\000\
  FLOAT\000\
  STR\000\
  "

let yyact = [|
  (fun _ -> failwith "parser")
; (fun __caml_parser_env ->
    let _2 = (Parsing.peek_val __caml_parser_env 0 : Ast.expr) in
    Obj.repr(
# 30 "parser.mly"
                            ( _2 )
# 121 "parser.ml"
               : Ast.expr))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 1 : 'expr) in
    Obj.repr(
# 31 "parser.mly"
                            ( _1 )
# 128 "parser.ml"
               : Ast.expr))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : 'value) in
    Obj.repr(
# 35 "parser.mly"
                            ( ECst _1 )
# 135 "parser.ml"
               : 'expr))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 2 : 'expr) in
    let _3 = (Parsing.peek_val __caml_parser_env 0 : 'expr) in
    Obj.repr(
# 36 "parser.mly"
                            ( EAdd (_1, _3) )
# 143 "parser.ml"
               : 'expr))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 2 : 'expr) in
    let _3 = (Parsing.peek_val __caml_parser_env 0 : 'expr) in
    Obj.repr(
# 37 "parser.mly"
                            ( EMul (_1, _3) )
# 151 "parser.ml"
               : 'expr))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 2 : 'expr) in
    let _3 = (Parsing.peek_val __caml_parser_env 0 : 'expr) in
    Obj.repr(
# 38 "parser.mly"
                            ( EAdd (_1, ENeg _3) )
# 159 "parser.ml"
               : 'expr))
; (fun __caml_parser_env ->
    let _2 = (Parsing.peek_val __caml_parser_env 0 : 'expr) in
    Obj.repr(
# 39 "parser.mly"
                            ( ENeg _2 )
# 166 "parser.ml"
               : 'expr))
; (fun __caml_parser_env ->
    let _2 = (Parsing.peek_val __caml_parser_env 1 : 'expr) in
    Obj.repr(
# 40 "parser.mly"
                            ( _2 )
# 173 "parser.ml"
               : 'expr))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : int) in
    Obj.repr(
# 44 "parser.mly"
                            ( VInt _1 )
# 180 "parser.ml"
               : 'value))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : float) in
    Obj.repr(
# 45 "parser.mly"
                            ( VFloat _1 )
# 187 "parser.ml"
               : 'value))
; (fun __caml_parser_env ->
    Obj.repr(
# 46 "parser.mly"
                            ( VBool true )
# 193 "parser.ml"
               : 'value))
; (fun __caml_parser_env ->
    Obj.repr(
# 47 "parser.mly"
                            ( VBool false )
# 199 "parser.ml"
               : 'value))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : string) in
    Obj.repr(
# 48 "parser.mly"
                            ( VStr _1 )
# 206 "parser.ml"
               : 'value))
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
