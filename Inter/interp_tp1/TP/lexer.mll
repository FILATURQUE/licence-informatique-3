{
open Parser
exception Eof
}


(* Déclaration du dictionnaire (regexp -> terminal/token) *)

rule anlex = parse
  | [' ' '\t' '\n' '\r']     { anlex lexbuf (* Oubli des espacements et passages à la ligne *) }
  | ['0'-'9']+ as lxm        { VAL(VInt(int_of_string lxm)) }
  | "/*"                     { comment lexbuf }  
  | '+'                      { PLUS }
  | '*'                      { TIME }
  | '-'                      { MINUS }
  | '('                      { LPAR }
  | ')'                      { RPAR }
  | "true"                   { VAL(VBool(true)) }
  | "false"                  { VAL(VBool(false)) }
  | ['0'-'9'] + '.' ['0'-'9']+ as f {VAL(VFloat(float_of_string f))}
  | ['A'-'Z' 'a'-'z'] ['A'-'Z' 'a'-'z' '0'-'9' '_']* as ident { ID ident }
  | ";;"                     { TERM }
  | eof                      { raise Eof }
  | _  as lxm                { (* Pour tout autre caractère : message sur la sortie erreur + oubli *)
                               Printf.eprintf "Unknown character '%c': ignored\n" lxm; flush stderr;
                               anlex lexbuf
                             }
and comment = parse
  |"*/"                      { anlex lexbuf }
  | _                        { comment lexbuf }

