# Regex in Java

---

```md

a|1     		[a1]
.	    		Any character, except '\n'
\d	    		[0-9]
\D	    		[^0-9]
\w	    		[a-zA-Z0-9_]
\W	    		[^a-zA-Z0-9_]
\s	    		[\t\n\r\f ]
\S	    		[^\t\n\r\f ]
\b	    		Word Boundaries (Whole Word)
\B	    		NonWord Boundaries (Whole Word)
\p{Lu}		Latin-1 ~ Uppercase_Letter
\p{Ll}		Latin-1 ~ Lowercase_Letter

re*	    		Zero or more
re+	    		One or more
re?	    		Zero or One
re{n}		Repeat n times
re{,m}		Repeat at most m times
re{n,}		Repeat at least n times
re{n,m}		Repeat n to m times

^re	    		The beginning of the string
\Are	    		The beginning of the string, exact whole word
re$			The end of the string
re\Z	    		The end of the string, exact whole word, except newline
re\z	    		The end of the string, exact whole word

(re)			Capturing group, use group id: (0) whole regex (1) group-1 (2) group-2 ...
\number			Backreference group-number
(?:re)			Non-capturing group, not save results
(?<name>re)		Named-capturing group, use group name ("name")

re(?=condition)		Positive Lookahead, re before condition
re(?!condition)		Negative Lookahead, re not before condition
(?<=condition)re		Positive Lookbehind, re after condition
(?<!condition)re		Negative Lookbehind, re not after condition

(?(group)re1|re2)		Group (id or name) exists then match re1, otherwise match re2
(?i:re)			Case-insensitive

```

---
