import sys
import io 
current_word=None;
curr_count =0;
word=None;
for line in sys.stdin:

    word,count=line.split('\t');
    count=int(count)
    if current_word==word:
     curr_count+=count;

    else:
        if current_word:
         print('%s\t%s'%(current_word,curr_count))
        current_word=word;
        curr_count=count;
if(current_word==word):
    print('%s\t%s'%(current_word,curr_count))
