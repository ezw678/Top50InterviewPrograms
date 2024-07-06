from hypothesis import given, strategies as st
import math
from top50 import *
from tree_node import TreeNode, root


@given(st.integers(min_value=2, max_value=500))
def test_int_palindrome(n: int):
    assert int_palindrome_1(n) == int_palindrome_2(n)


@given(st.lists(st.integers(), min_size=0, max_size=50))
def test_remove_dups_in_list(nums: list[int]):
    assert (
        sorted(remove_dups_in_list_1(nums))
        == sorted(remove_dups_in_list_2(nums))
        == sorted(remove_dups_in_list_3(nums))
    )


@given(st.lists(st.integers(), min_size=0, max_size=50))
def test_del_dups_in_list(nums: list[int]):
    assert sorted(del_dups_in_list_1(nums)) == sorted(del_dups_in_list_2(nums))


@given(st.text())
def test_find_dup_chars_in_str(s: str):
    assert find_dup_chars_in_str_1(s) == find_dup_chars_in_str_2(s)


@given(st.floats(min_value=0.00001, max_value=200.0))
def test_find_sqrt(n: int):
    assert abs(find_sqrt(n) - math.sqrt(n)) <= 0.00000001


def test_find_first_non_repeat_char_1():
    assert find_first_non_repeat_char_1("hello") == "h"
    assert find_first_non_repeat_char_1("programming") == "p"
    assert find_first_non_repeat_char_1("preparing") == "e"


def test_find_first_non_repeat_char_2():
    assert find_first_non_repeat_char_2("hello") == "h"
    assert find_first_non_repeat_char_2("programming") == "p"
    assert find_first_non_repeat_char_2("preparing") == "e"


@given(st.text())
def test_find_first_non_repeat_char(s: str):
    assert find_first_non_repeat_char_1(s) == find_first_non_repeat_char_2(s)


@given(st.lists(st.integers(), min_size=10, max_size=50))
def test_sort_algorithms(nums: list[int]):
    c1 = nums[:]
    insertion_sort(c1)
    c2 = nums[:]
    bubble_sort(c2)
    assert c1 == c2 == sorted(nums)


@given(st.lists(st.integers(), min_size=10, max_size=50))
def test_quicksort_1(nums: list[int]):
    nums_copy = nums[:]
    quicksort_1(nums_copy, 0, len(nums) - 1)
    assert nums_copy == sorted(nums)


@given(st.lists(st.integers(), min_size=10, max_size=50))
def test_quicksort_2(nums: list[int]):
    assert quicksort_2(nums) == sorted(nums)


@given(st.lists(st.integers(), min_size=10, max_size=50))
def test_merge_sort(nums: list[int]):
    assert merge_sort(nums) == sorted(nums)


def test_pre_order_traversal():
    lst = []
    pre_order_traversal_recursive(root, lst)
    assert pre_order_traversal(root) == lst


def test_in_order_traversal():
    lst = []
    in_order_traversal_recursive(root, lst)
    assert in_order_traversal(root) == lst


def test_post_order_traversal():
    lst = []
    post_order_traversal_recursive(root, lst)
    assert post_order_traversal(root) == lst


@given(st.text(min_size=2, max_size=8))
def test_str_permutation(word):
    lst0 = []
    str_permutation_1(word, 0, len(word) - 1, lst0)
    lst1 = []
    str_permutation_2(word, "", lst1)
    assert sorted(lst0) == sorted(lst1)
